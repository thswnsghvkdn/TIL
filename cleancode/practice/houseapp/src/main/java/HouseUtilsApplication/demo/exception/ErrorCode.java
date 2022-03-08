package HouseUtilsApplication.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

// 에러코드를 enum타입으로 따로 관리할 경우 츠로젝트에서 발생할 수 있는 에러들을 관리하기 쉽다.
@Getter
@AllArgsConstructor
public enum ErrorCode {
    INVALID_REQUEST ("잘못된 요청입니다."),
    INTERNAL_ERROR ("알 수 없는 에러가 발생했습니다."),
    ENTITY_NOT_FOUND ("데이터를 찾을 수 없습니다.");
    private String message;
}
