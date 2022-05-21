package capston.thecloset.domain;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Category {
    Outer,Top,Pants,Dress,Shoes,Bag;

    private String value;

    Category(String value){
        this.value = value;
    }

    Category() {

    }

    public static Category fromCode(String dbData){
        return Arrays.stream(Category.values())
                .filter(v->v.getValue().equals(dbData))
                .findAny()
                .orElseThrow(() -> new IllegalStateException(String.format("아이템 카테고리에 %s가 존재하지 않습니다.",dbData)));
    }
}
