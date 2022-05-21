package capston.thecloset.domain;

import capston.thecloset.Convert.ItemCategoryConverter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.time.LocalDateTime;
import static javax.persistence.FetchType.LAZY;

@Entity
@NoArgsConstructor
@Getter
public class Item {

    @Id @GeneratedValue
    @Column(name="item_id")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private Member member;

    @Column(name = "RegDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime regdt;

    @Convert(converter = ItemCategoryConverter.class)
    private Category category;


    private String filename;//이미지 파일명
    private String filepath; //이미지 조회 경로

    //===연관관계 메소드===
    public void setMember(Member member){
        this.member=member;
       member.getItemList().add(this);
    }


    public Item(String filename, String filepath,String category)
    {
        this.regdt=LocalDateTime.now();
        this.filename=filename;
        this.filepath=filepath;
        this.category= Category.valueOf(classification(category));
    }

    public Item(String category){
        this.regdt=LocalDateTime.now();
        this.category= Category.valueOf(classification(category));
    }

    //카테고리 분류 비지니스 로직
    public String classification(String category) {
        String str = null;
        switch (category) {
            case "T-shirt/top": case "Pullover": case "shirt":
                str = "Top";break;
            case "Trouser":
                str = "Pants";break;
            case "Dress":
                str = "Dress";
                break;
            case "Coat":
                str = "Outer";break;
            case "Sandal":
            case "Sneaker":
                str = "Shoes";break;
            case "Bag":
                str = "Bag";break;
        }
        return str;
    }
}
