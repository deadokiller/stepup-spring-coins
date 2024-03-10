package ru.vtb.javapro.homework.mapping;

import org.mapstruct.Mapper;
import ru.vtb.javapro.homework.model.UserProductResponse;
import ru.vtb.javapro.homework.model.UserProductResponseView;

import java.util.List;

@Mapper
public interface UserProductResponseMapper {

    List<UserProductResponse> mapUserProductResponse(List<UserProductResponseView> userProductResponseViewList);
}
