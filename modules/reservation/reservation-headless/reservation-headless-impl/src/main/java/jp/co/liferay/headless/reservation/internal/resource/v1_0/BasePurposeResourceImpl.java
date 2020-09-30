package jp.co.liferay.headless.reservation.internal.resource.v1_0;

import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.portal.vulcan.util.TransformUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.annotation.Generated;

import javax.validation.constraints.NotNull;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import jp.co.liferay.headless.reservation.dto.v1_0.Purpose;
import jp.co.liferay.headless.reservation.resource.v1_0.PurposeResource;

/**
 * @author Maurice Sepe
 * @generated
 */
@Generated("")
@Path("/v1.0")
public abstract class BasePurposeResourceImpl implements PurposeResource {

	@Override
	@GET
	@Operation(
		description = "Retrieve the list of purposes. Results can be paginated, filtered, searched and sorted."
	)
	@Parameters(
		value = {
			@Parameter(in = ParameterIn.QUERY, name = "search"),
			@Parameter(in = ParameterIn.QUERY, name = "filter"),
			@Parameter(in = ParameterIn.QUERY, name = "page"),
			@Parameter(in = ParameterIn.QUERY, name = "pageSize"),
			@Parameter(in = ParameterIn.QUERY, name = "sort")
		}
	)
	@Path("/purposes")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Purpose")})
	public Page<Purpose> getPurposesPage(
			@Parameter(hidden = true) @QueryParam("search") String search,
			@Context Filter filter, @Context Pagination pagination,
			@Context Sort[] sorts)
		throws Exception {

		return Page.of(Collections.emptyList());
	}

	@Override
	@Consumes({"application/json", "application/xml"})
	@Operation(description = "Create a new purpose tag.")
	@POST
	@Path("/purposes")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Purpose")})
	public Purpose postPurpos(Purpose purpose) throws Exception {
		return new Purpose();
	}

	@Override
	@DELETE
	@Operation(
		description = "Deletes the purpose and returns a 204 if the operation succeeds."
	)
	@Parameters(value = {@Parameter(in = ParameterIn.PATH, name = "purposeId")})
	@Path("/purposes/{purposeId}")
	@Produces("application/json")
	@Tags(value = {@Tag(name = "Purpose")})
	public void deletePurposPurpose(
			@NotNull @Parameter(hidden = true) @PathParam("purposeId") String
				purposeId)
		throws Exception {
	}

	@Override
	@GET
	@Operation(description = "Retrieves the purpose via its ID.")
	@Parameters(value = {@Parameter(in = ParameterIn.PATH, name = "purposeId")})
	@Path("/purposes/{purposeId}")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Purpose")})
	public Purpose getPurposPurpose(
			@NotNull @Parameter(hidden = true) @PathParam("purposeId") String
				purposeId)
		throws Exception {

		return new Purpose();
	}

	@Override
	@Consumes({"application/json", "application/xml"})
	@Operation(description = "Updates and overwrites the target purpose.")
	@PUT
	@Parameters(value = {@Parameter(in = ParameterIn.PATH, name = "purposeId")})
	@Path("/purposes/{purposeId}")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Purpose")})
	public Purpose putPurposPurpose(
			@NotNull @Parameter(hidden = true) @PathParam("purposeId") String
				purposeId,
			Purpose purpose)
		throws Exception {

		return new Purpose();
	}

	public void setContextCompany(Company contextCompany) {
		this.contextCompany = contextCompany;
	}

	protected void preparePatch(Purpose purpose, Purpose existingPurpose) {
	}

	protected <T, R> List<R> transform(
		Collection<T> collection,
		UnsafeFunction<T, R, Exception> unsafeFunction) {

		return TransformUtil.transform(collection, unsafeFunction);
	}

	protected <T, R> R[] transform(
		T[] array, UnsafeFunction<T, R, Exception> unsafeFunction,
		Class<?> clazz) {

		return TransformUtil.transform(array, unsafeFunction, clazz);
	}

	protected <T, R> R[] transformToArray(
		Collection<T> collection,
		UnsafeFunction<T, R, Exception> unsafeFunction, Class<?> clazz) {

		return TransformUtil.transformToArray(
			collection, unsafeFunction, clazz);
	}

	protected <T, R> List<R> transformToList(
		T[] array, UnsafeFunction<T, R, Exception> unsafeFunction) {

		return TransformUtil.transformToList(array, unsafeFunction);
	}

	@Context
	protected AcceptLanguage contextAcceptLanguage;

	@Context
	protected Company contextCompany;

	@Context
	protected UriInfo contextUriInfo;

}