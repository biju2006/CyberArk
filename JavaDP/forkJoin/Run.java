import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

public class Run {

	/**
	 * args[0] is the location to start (e.g. "c:/myDir")
	 * args[1] is the file extension to search (e.g. "exe")
	 */
	public static void main(String[] args) {
		long start=System.currentTimeMillis();
		Collection<String> files=new Vector<>();
		DirectorySearch search=new DirectorySearchargs[0],args[1],files);
		ForkJoinPool pool=new ForkJoinPool();
		
		System.out.println("Searching Directories: \n");
		
		pool.invoke(search);
		
		System.out.println("\n\nFounded Files: \n");
		for(String file:files){
			System.out.println(file);
		}
		
		System.out.println(System.currentTimeMillis()-start+" milis");

	}

}
