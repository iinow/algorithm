package algorithm.brother;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Ex2 {
	private static Map<String, Integer> map = new TreeMap<>();
	
	public String solution(String S) {
		Extension.fileExtension.forEach(file -> {
			map.put(file, 0);
		});
		
		String[] lines = S.split("\n");
		for(String line: lines) {
			String[] strs = line.split("\\s");
			String type = findLine(strs[0]);
			int size = Integer.parseInt(strs[1].substring(0, strs[1].length() - 1));
			map.put(type, map.get(type) + size);
		}
		
		StringBuilder builder = new StringBuilder();
		Extension.fileExtension.forEach(file->{
			builder.append(file+" "+map.get(file)+"b\r\n");
		});
		return builder.toString();
    }
	
	public static String findLine(String s) {
		for(Extension[] exs: Extension.extension) {
			for(Extension ex: exs) {
				String type = ex.findType(s);
				if(type == null) {
					continue;
				}
				
				return type;
			}
		}
		return "other";
	}
	
	public static void main(String[] args) {
		Ex2 e = new Ex2();
		String res = e.solution("my.song.mp3 11b\ngreatSong.flac 1000b\nnot3.txt 5b\nvideo.mp4 200b\ngame.exe 100b\nmov!e.mkv 10000b");
		System.out.println(res);
	}
}

interface Extension {
	public static final List<Extension[]> extension = Arrays.asList(Music.values(), Image.values(), Movie.values());
	public static final List<String> fileExtension = Arrays.asList("music", "images", "movies", "other");
	public static final String fileNameRegex = "[a-zA-Z0-9\\^\\&\\'\\@\\{\\}\\[\\]\\,\\$\\=\\!\\-\\#\\(\\)\\%\\.\\+\\~\\_]*.";
	String findType(String name);
}

enum Music implements Extension {
	mp3("mp3"), aac("aac"), flac("flac");
	
	final String type;
	Music(String type){
		this.type = type;
	}
	
	@Override
	public String findType(String name) {
		String[] strs = name.split(fileNameRegex+ this.type);
		if(strs.length == 0) {
			return "music";
		}
		return null;
	}
}

enum Image implements Extension {
	jpg("jpg"), bmp("bmp"), gif("gif");

	final String type;
	Image(String type){
		this.type = type;
	}
	
	@Override
	public String findType(String name) {
		String[] strs = name.split(fileNameRegex+ this.type);
		if(strs.length == 0) {
			return "images";
		}
		return null;
	}
}

enum Movie implements Extension {
	mp4("mp4"), avi("avi"), mkv("mkv");

	final String type;
	Movie(String type){
		this.type = type;
	}
	
	@Override
	public String findType(String name) {
		String[] strs = name.split(fileNameRegex+ this.type);
		if(strs.length == 0) {
			return "movies";
		}
		return null;
	}
}