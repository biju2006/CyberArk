package JavaEssentials.JavaStreams;

import java.util.List;

public class SearchEngine<T> {
	
	private List<T> data;
	private T toSreach;
	private long lastSearchTimeInMillis;
	
	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public T getToSreach() {
		return toSreach;
	}

	public void setToSreach(T toSreach) {
		this.toSreach = toSreach;
	}

	public long getLastSearchTimeInMillis() {
		return lastSearchTimeInMillis;
	}

	public List<T> executeSearch(SearchTask<T> task){
		long time=task.startSearch();
		List<T> results=task.search(data);
		lastSearchTimeInMillis=task.endSearch()-time;
		return results;
	}
}
