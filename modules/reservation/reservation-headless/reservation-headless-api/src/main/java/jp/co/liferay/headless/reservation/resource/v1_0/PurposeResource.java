package jp.co.liferay.headless.reservation.resource.v1_0;

import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import javax.annotation.Generated;

import jp.co.liferay.headless.reservation.dto.v1_0.Purpose;

/**
 * To access this resource, run:
 *
 *     curl -u your@email.com:yourpassword -D - http://localhost:8080/o/reservation-headless/v1.0
 *
 * @author Maurice Sepe
 * @generated
 */
@Generated("")
public interface PurposeResource {

	public Page<Purpose> getPurposesPage(
			String search, Filter filter, Pagination pagination, Sort[] sorts)
		throws Exception;

	public Purpose postPurpos(Purpose purpose) throws Exception;

	public void deletePurposPurpose(String purposeId) throws Exception;

	public Purpose getPurposPurpose(String purposeId) throws Exception;

	public Purpose putPurposPurpose(String purposeId, Purpose purpose)
		throws Exception;

	public void setContextCompany(Company contextCompany);

}