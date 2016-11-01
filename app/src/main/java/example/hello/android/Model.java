package example.hello.android;

public class Model {
    // 변수들
    private String nickname;
    private String message;

    // 생성자
    public Model() {

    }

    public Model(String nickname, String message) {
        this.nickname = nickname;
        this.message = message;
    }

    // 함수들
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNickname() {

        return this.nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }


}
















