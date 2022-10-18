class MainMenu extends AbstractMenu {//AbstractMenu을 상속받음
    private static final MainMenu instance = new MainMenu(null);//자기 자신의 객체 생성
    private static final String MAIN_MENU_TEXT =//기본문구
            "1: 영화 예매하기\n" +
            "2: 예매 확인하기\n" +
            "3: 예매 취소하기\n" +
            "4: 관리자 메뉴로 이동\n" +
            "q: 종료\n\n" +
            "메뉴를 선택하세요 : ";

    private  MainMenu(Menu preMenu){//private생성자(외부에서 객체 생성 불가)
        super(MAIN_MENU_TEXT,preMenu);//부모 생성자 호출
    }

    public static MainMenu getInstance(){
        return instance;//메뉴 객체 반환
    }

    public Menu next(){
        switch (scanner.nextLine()){//사용자 입력을 행 단위로 가져옴
            case "q": return prevMenu;//q 입력 시, preMenu를 반환
            default: return this;// 그 외 입력은 메인 메뉴(this)로 돌아감.
        }
    }

}
