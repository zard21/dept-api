package kr.codelab.demo.code;

import lombok.Getter;

public enum ResponseCode {

    SUCCESS("0000", "정상처리"),
    FAIL("9999", "오류발생");

    @Getter
    private String code;

    @Getter
    private String message;

    ResponseCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
