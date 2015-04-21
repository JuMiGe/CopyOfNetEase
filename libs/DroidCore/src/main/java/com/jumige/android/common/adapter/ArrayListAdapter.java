
package com.jumige.android.common.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * 通用的AbsListView的BaseAdapter
 * @param <T>  The class You want to Put in the ArrayList
 */
public abstract class ArrayListAdapter<T> extends BaseAdapter {

	protected ArrayList<T> mList ;
	protected Context mContext;
	protected AdapterView mListView;
	protected LayoutInflater mInflater;
    /**
     * <p></p>是否是同一个List, 默认的是一个</p>
     * <p></p>若不是同一个使用的是传进来的哪儿ArrayList</p>
     */
    private boolean isSameList = false;

	public ArrayListAdapter(Context context){
		this(context,false);
	}

    public ArrayListAdapter(Context context, boolean isSamelist){
        this.mContext = context;
        mInflater = LayoutInflater.from(context);
        if (!isSamelist)
            mList = new ArrayList<T>();

    }
	@Override
	public int getCount() {
		if(mList != null)
			return mList.size();
		else
			return 0;
	}

	@Override
	public T getItem(int position) {
		return mList == null ? null : mList.get(position );
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	abstract public View getView(int position, View convertView, ViewGroup parent);
	
	public void setList(ArrayList<T> list){
		this.mList = list;
		notifyDataSetChanged();
	}
	
	public ArrayList<T> getList(){
		return mList;
	}
	
	public void setList(T[] list){
        ArrayList<T> arrayList = new ArrayList<T>(list.length);
		for (T t : list) {  
			arrayList.add(t);  
		}  
		setList(arrayList);
	}
	

	
	public void setListView(AdapterView listView){
		mListView = listView;
	}
	
	public void addData(ArrayList<T> list)
	{
		mList.addAll(list);
		notifyDataSetChanged();
	}

    public void addData(T[] list){
        ArrayList<T> arrayList = new ArrayList<T>(list.length);
        for (T t : list) {
            arrayList.add(t);
        }
        mList.addAll(arrayList);
        notifyDataSetChanged();
    }

    public void addItem(T t)
	{
		mList.add(0,t);
		notifyDataSetChanged();
	}

    public void addItem2Last(T t)
    {
        mList.add(mList.size(), t);
        notifyDataSetChanged();
    }
	
	public void clearData()
	{
		if(mList != null)
		{
			mList.clear();
		}
		notifyDataSetChanged();
	}

    /**
     * Removes the specified element from the list
     */
    public void remove(T item) {
        mList.remove(item);
        notifyDataSetChanged();
    }

    /**
     * Removes the element at the specified position in the list
     */
    public void remove(int position) {
        mList.remove(position);
        notifyDataSetChanged();
    }

    /**
     * Removes all elements at the specified positions in the list
     */
    public void removePositions(Collection<Integer> positions) {
        ArrayList<Integer> positionsList = new ArrayList<Integer>(positions);
        Collections.sort(positionsList);
        Collections.reverse(positionsList);
        for (int position : positionsList) {
            mList.remove(position);
        }
        notifyDataSetChanged();
    }

    /**
     * Removes all of the list's elements that are also contained in the
     * specified collection
     */
    public void removeAll(Collection<T> items) {
        mList.removeAll(items);
        notifyDataSetChanged();
    }

    /**
     * Retains only the elements in the list that are contained in the specified
     * collection
     */
    public void retainAll(Collection<T> items) {
        mList.retainAll(items);
        notifyDataSetChanged();
    }

    /**
     * Returns the position of the first occurrence of the specified element in
     * this list, or -1 if this list does not contain the element. More
     * formally, returns the lowest position <tt>i</tt> such that
     * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>,
     * or -1 if there is no such position.
     */
    public int indexOf(T item) {
        if (mList == null )
            return mList.indexOf(item);
        else
            return    -1;
    }

    public boolean isSameList() {
        return isSameList;
    }

    public void setSameList(boolean isSameList) {
        this.isSameList = isSameList;
    }
}
