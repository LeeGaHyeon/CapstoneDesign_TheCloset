package capston.thecloset.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.time.LocalDateTime;

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

    @Enumerated(EnumType.STRING)
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
                str = "TOP";break;
            case "Trouser":
                str = "PANTS";break;
            case "Dress":
                str = "DRESS";
                break;
            case "Coat":
                str = "OUTER";break;
            case "Sandal":
            case "Sneaker":
                str = "SHOES";break;
            case "Bag":
                str = "BAG";break;
        }
        return str;
    }
}
