package farmindia.bmpl.com.farmindia;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by nikhilgupta on 29/03/17.
 */

public abstract class FirebaseRecyclerAdapter<T, VH extends RecyclerView.ViewHolder>
        extends RecyclerView.Adapter<VH> {
    private static final String TAG = "FirebaseRecyclerAdapter";

    private FirebaseArray mSnapshots;
    private Class<T> mModelClass;
    protected Class<VH> mViewHolderClass;
    protected int mModelLayout;

    FirebaseRecyclerAdapter(Class<T> modelClass,
                            @LayoutRes int modelLayout,
                            Class<VH> viewHolderClass,
                            FirebaseArray snapshots) {
        mModelClass = modelClass;
        mModelLayout = modelLayout;
        mViewHolderClass = viewHolderClass;
        mSnapshots = snapshots;

        mSnapshots.setOnChangedListener(new ChangeEventListener() {
            @Override
            public void onChildChanged(EventType type, int index, int oldIndex) {
                FirebaseRecyclerAdapter.this.onChildChanged(type, index, oldIndex);
            }

            @Override
            public void onDataChanged() {
                FirebaseRecyclerAdapter.this.onDataChanged();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                FirebaseRecyclerAdapter.this.onCancelled(error);
            }
        });
    }

    /**
     * @param modelClass      Firebase will marshall the data at a location into
     *                        an instance of a class that you provide
     * @param modelLayout     This is the layout used to represent a single item in the list.
     *                        You will be responsible for populating an instance of the corresponding
     *                        view with the data from an instance of modelClass.
     * @param viewHolderClass The class that hold references to all sub-views in an instance modelLayout.
     * @param ref             The Firebase location to watch for data changes. Can also be a slice of a location,
     *                        using some combination of {@code limit()}, {@code startAt()}, and {@code endAt()}.
     */
    public FirebaseRecyclerAdapter(Class<T> modelClass,
                                   int modelLayout,
                                   Class<VH> viewHolderClass,
                                   Query ref) {
        this(modelClass, modelLayout, viewHolderClass, new FirebaseArray(ref));
    }

    public void cleanup() {
        mSnapshots.cleanup();
    }

    @Override
    public int getItemCount() {
        return mSnapshots.getCount();
    }

    public T getItem(int position) {
        return parseSnapshot(mSnapshots.getItem(position));
    }

    /**
     * This method parses the DataSnapshot into the requested type. You can override it in subclasses
     * to do custom parsing.
     *
     * @param snapshot the DataSnapshot to extract the model from
     * @return the model extracted from the DataSnapshot
     */
    protected T parseSnapshot(DataSnapshot snapshot) {
        return snapshot.getValue(mModelClass);
    }

    public DatabaseReference getRef(int position) {
        return mSnapshots.getItem(position).getRef();
    }

    @Override
    public long getItemId(int position) {
        // http://stackoverflow.com/questions/5100071/whats-the-purpose-of-item-ids-in-android-listview-adapter
        return mSnapshots.getItem(position).getKey().hashCode();
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        try {
            Constructor<VH> constructor = mViewHolderClass.getConstructor(View.class);
            return constructor.newInstance(view);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onBindViewHolder(VH viewHolder, int position) {
        T model = getItem(position);
        populateViewHolder(viewHolder, model, position);
    }

    @Override
    public int getItemViewType(int position) {
        return mModelLayout;
    }

    /**
     * @see ChangeEventListener#onChildChanged(ChangeEventListener.EventType, int, int)
     */
    protected void onChildChanged(ChangeEventListener.EventType type, int index, int oldIndex) {
        switch (type) {
            case ADDED:
                notifyItemInserted(index);
                break;
            case CHANGED:
                notifyItemChanged(index);
                break;
            case REMOVED:
                notifyItemRemoved(index);
                break;
            case MOVED:
                notifyItemMoved(oldIndex, index);
                break;
            default:
                throw new IllegalStateException("Incomplete case statement");
        }
    }

    /**
     * @see ChangeEventListener#onDataChanged()
     */
    protected void onDataChanged() {
    }

    /**
     * @see ChangeEventListener#onCancelled(DatabaseError)
     */
    protected void onCancelled(DatabaseError error) {
        Log.w(TAG, error.toException());
    }

    /**
     * Each time the data at the given Firebase location changes,
     * this method will be called for each item that needs to be displayed.
     * The first two arguments correspond to the mLayout and mModelClass given to the constructor of
     * this class. The third argument is the item's position in the list.
     * <p>
     * Your implementation should populate the view using the data contained in the model.
     *
     * @param viewHolder The view to populate
     * @param model      The object containing the data used to populate the view
     * @param position   The position in the list of the view being populated
     */
    protected abstract void populateViewHolder(VH viewHolder, T model, int position);
}