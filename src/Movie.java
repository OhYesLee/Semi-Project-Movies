import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Movie {
    private long id;//영화 대푯값
    private String title;//영화 제목
    private String genre;//영화 장르
    private static final File file = new File("movies.txt"); //movies.txt 파일 객체

    public Movie(long id, String title, String genre) {//생성자
        this.id = id;
        this.title = title;
        this.genre = genre;
    }

    public static ArrayList<Movie> findAll() throws IOException { //IOException 입출력 예외 발생 시, 호출 위치로 전달
        ArrayList<Movie> movies = new ArrayList<Movie>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = null;

        while ((line = br.readLine()) != null) { // 파일을 한 행씩 읽어와 반복
            String[] temp = line.split(",");// 쉼표를 기준으로 문자열을 나눔
            Movie m = new Movie(                    // 영화 객체 생성
                    Long.parseLong(temp[0]),        //영화 대푯값
                    temp[1],                        //영화 제목
                    temp[2]                         //영화 장르
            );
            movies.add(m);                          //생성 영화 객체를 ArrayList 에 추가
        }
        br.close();                                 //파일 입력 흐름 해제
        return movies;                              // 영화 객체가 담긴 ArrayList 반환
    }

    // 모든 영화 정보를 ArrayList<Movie> 에 담아 반환
    public String toString() {
        return String.format("[%d]: %s(%s)", id, title, genre);
    }                       // 객체 정보를 문자열로 반환
}
