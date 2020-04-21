package cc.openhome;

import java.net.URL;
import java.util.concurrent.*;
import java.io.*;

public class Pages {
    private URL[] urls;
    private String[] fileNames;
    private Executor executor;

    public Pages(URL[] urls, String[] fileNames, Executor executor) {
        this.urls = urls;
        this.fileNames = fileNames;
        this.executor = executor;
    }

    public void download() {
        for(var i = 0; i < urls.length; i++) {
            var url = urls[i];
            var fileName = fileNames[i];
            executor.execute(() -> {
                try {
                    dump(url.openStream(), new FileOutputStream(fileName));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
        }
    }

    private void dump(InputStream src, OutputStream dest) throws IOException {
        try(src; dest) { 
            var data = new byte[1024];
            var length = 0;
            while((length = src.read(data)) != -1) {
                dest.write(data, 0, length);
            }
        }
    }
}
