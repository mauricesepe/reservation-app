package jp.co.liferay.headless.reservation.internal.odata.entity.v1_0;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.odata.entity.CollectionEntityField;
import com.liferay.portal.odata.entity.DateTimeEntityField;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.odata.entity.StringEntityField;

public class BookingEntityModel implements EntityModel {
    
    public BookingEntityModel() {
		_entityFieldsMap = Stream.of(
                new CollectionEntityField(new StringEntityField("participantIds", locale -> "participantIds")),
                new StringEntityField("title", 
                        locale -> Field.getSortableFieldName("title")),
                new StringEntityField("userId", 
                        locale -> Field.getSortableFieldName("userId")),
                new StringEntityField("roomId", 
                        locale -> Field.getSortableFieldName("roomId")),
                new DateTimeEntityField("startDate", 
                        locale -> Field.getSortableFieldName("startDate"), 
                        locale -> "startDate"),
                new DateTimeEntityField("endDate", 
                        locale -> Field.getSortableFieldName("endDate"), 
                        locale -> "endDate")
		).collect(
				Collectors.toMap(EntityField::getName, Function.identity())
		);
	}

    @Override
	public Map<String, EntityField> getEntityFieldsMap() {
		return _entityFieldsMap;
	}

	private final Map<String, EntityField> _entityFieldsMap;
}