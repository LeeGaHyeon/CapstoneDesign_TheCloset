package capston.thecloset.service;

import capston.thecloset.domain.Item;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ItemCategoryDto {

   // private String userId;
    private String filePath;
    private String category;

    public ItemCategoryDto(String filePath, String category){
        //this.userId=userId;
        this.filePath = filePath;
        this.category=category;
    }


    //EntityList->DtoList
    public static List<ItemCategoryDto> of(List<Item> itemList){
        if(itemList !=null){
            List<ItemCategoryDto> itemImgList = new ArrayList<>();
            for(Item x : itemList){
                itemImgList.add(of(x));
            }
            return itemImgList;
        }
        return null;
    }

    //Entity -> Dto
    public static ItemCategoryDto of(Item item){
         return new ItemCategoryDto(item.getFilepath(),item.getCategory().toString());
    }
}
