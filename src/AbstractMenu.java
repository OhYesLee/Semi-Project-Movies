import java.util.Scanner;
//추상클래스 생성               // 메뉴 인터페이스를 구현
abstract class AbstractMenu implements Menu {
    protected String menuText; //기본문구
    protected Menu prevMenu;//이전메뉴
    protected static final Scanner scanner = new Scanner(System.in);//키보드 입력을 위한 객체 생성

    public AbstractMenu(String menuText, Menu prevMenu) {//생성자
        this.menuText = menuText;
        this.prevMenu = prevMenu;
    }

    public void print() {  // Menu 인터페이스의 print() 메소드를 재정의
        System.out.print("\n" + menuText);//메뉴출력
    }

    public void setPrevMenu(Menu prevMenu) {//세터 메소드
        this.prevMenu = prevMenu;
    }
}
