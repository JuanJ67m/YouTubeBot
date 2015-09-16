import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

public class Downloader {

	public void downloadVideo(String link) throws IOException {
		URL url = new URL(link);
		File file = new File("C:\\YTBDownloads\\video.mp4");
		FileUtils.copyURLToFile(url, file);
	}

}
