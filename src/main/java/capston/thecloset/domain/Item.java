package capston.thecloset.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Optional;

import static javax.persistence.FetchType.LAZY;

@Entity
@NoArgsConstructor
@Getter
public class Item {

    @Id @GeneratedValue
    @Column(name="item_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="user_id")
    private Member member;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "RegDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime regdt;

    private String filename;//이미지 파일명
    private String filepath; //이미지 조회 경로

    //===연관관계 메소드===
    public void setMember(Member member){
        this.member=member;
        member.getItemList().add(this);
    }

    public Item(String filename , String filepath)
    {
        this.regdt=LocalDateTime.now();
        this.filename=filename;
        this.filepath=filepath;
    }










}
