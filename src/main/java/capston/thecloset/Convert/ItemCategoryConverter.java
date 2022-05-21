package capston.thecloset.Convert;

import capston.thecloset.domain.Category;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;
import javax.persistence.Converter;

@Converter
@Slf4j
public class ItemCategoryConverter implements AttributeConverter<Category,String> {

    @Override
    public String convertToDatabaseColumn(Category category) {
        if(category == null) return null;
        return category.name();
    }

    @Override
    public Category convertToEntityAttribute(String dbData) {
        if(dbData == null){
        return null;
        }
        try {
            return Category.fromCode(dbData);
        }catch (IllegalStateException e){
            log.error("failure to convert cause unexpected code [{}]",dbData,e);
            throw e;
        }
    }
}
