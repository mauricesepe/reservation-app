package jp.co.liferay.headless.reservation.internal.odata.entity.v1_0;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.odata.entity.BooleanEntityField;
import com.liferay.portal.odata.entity.CollectionEntityField;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.odata.entity.IntegerEntityField;
import com.liferay.portal.odata.entity.StringEntityField;

public class RoomEntityModel implements EntityModel {

    public RoomEntityModel() {
		_entityFieldsMap = Stream.of(
                new CollectionEntityField(new StringEntityField("purposeIds", locale -> "purposeIds")),
                new CollectionEntityField(new StringEntityField("amenityIds", locale -> "amenityIds")),
                new StringEntityField("officeId", 
                        locale -> Field.getSortableFieldName("officeId")),
                new StringEntityField("name", 
                        locale -> Field.getSortableFieldName("name")),
                new IntegerEntityField("capacityPeople", 
                        locale -> Field.getSortableFieldName("capacityPeople")),
                new IntegerEntityField("capacitySquareMeters", 
                        locale -> Field.getSortableFieldName("capacitySquareMeters")),
                new IntegerEntityField("availableStartTime", 
                        locale -> Field.getSortableFieldName("availableStartTime")),
                new IntegerEntityField("availableEndTime", 
                        locale -> Field.getSortableFieldName("availableEndTime")),
                
                new BooleanEntityField("availableMonday", locale -> "availableMonday"),
                new BooleanEntityField("availableTuesday", locale -> "availableTuesday"),
                new BooleanEntityField("availableWednesday", locale -> "availableWednesday"),
                new BooleanEntityField("availableThursday", locale -> "availableThursday"),
                new BooleanEntityField("availableFriday", locale -> "availableFriday"),
                new BooleanEntityField("availableSaturday", locale -> "availableSaturday"),
                new BooleanEntityField("availableSunday", locale -> "availableSunday")
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