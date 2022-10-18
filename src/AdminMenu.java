import java.io.IOException;
import java.util.ArrayList;

public class AdminMenu extends AbstractMenu {
    private static final AdminMenu instance = new AdminMenu(null);
    private static final String ADMIN_MENU_TEXT =
            "1: 영화 등록하기\n" +
                    "2: 영화 목록 보기\n" +
                    "3: 영화 삭제하기\n" +
                    "b: 메인 메뉴로 이동\n\n" +
                    "메뉴를 선택하세요 : ";

    private AdminMenu(Menu prevMenu) {
        super(ADMIN_MENU_TEXT, prevMenu);
    }

    public static AdminMenu getInstance() {
        return instance;  // 메뉴 객체를 반환
    }

    public Menu next() {
        switch (scanner.nextLine()) {
            case "2": // 2번 메뉴 선택시
                printAllMovies(); // 영화 목록 출력
                return this; // 관리자 메뉴 객체 반환
            case "b"://b입력시 이전 메뉴를 반환
                return prevMenu;
            default:
                return this;
        }
    }

    private void printAllMovies() {
        try {
            ArrayList<Movie> movies = Movie.findAll(); // 모든 영화를 가져옴
            System.out.println();
            for (int i = 0; i < movies.size(); i++) {
                System.out.printf("%s\n", movies.get(i).toString()); // 출력
            }
        } catch (IOException e) {
            System.out.println("데이터 접근에 실패하였습니다."); // 예외 처리
        }
    }
}
