package jp.co.liferay.headless.reservation.internal.odata.entity.v1_0;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.odata.entity.StringEntityField;

public class ParticipantEntityModel implements EntityModel {

    public ParticipantEntityModel() {
        _entityFieldsMap = Stream.of(
                new StringEntityField("emailAddress", 
                /* use a different index since emailAddress is already used */
                        locale -> Field.getSortableFieldName("email")),
                new StringEntityField("fullName", 
                        locale -> Field.getSortableFieldName("fullName")),
                new StringEntityField("companyName", 
                        locale -> Field.getSortableFieldName("companyName"))
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