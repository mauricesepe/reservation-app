export const properties = {
  queryTimeout: 500,
  icons: Liferay.ThemeDisplay.getPathThemeImages() + "/lexicon/icons.svg",
  authToken: Liferay.authToken,
  companyId: Liferay.ThemeDisplay.getCompanyId(),
  portalURL: Liferay.ThemeDisplay.getPortalURL()
};

const endpointPaths = {
  roomsEndpoint: "/o/reservation-headless/v1.0/rooms",
  officesEndpoint: "/o/reservation-headless/v1.0/offices",
  purposesEndpoint: "/o/reservation-headless/v1.0/purposes",
  bookingsEndpoint: "/o/reservation-headless/v1.0/bookings",
  amenitiesEndpoint: "/o/reservation-headless/v1.0/amenities",
  participantsEndpoint: "/o/reservation-headless/v1.0/participants",
  usersEndpoint: "/api/jsonws/user/get-company-users/company-id/"+ properties.companyId +"/start/-1/end/-1",
};

for (var key in endpointPaths) {
	endpointPaths[key] = properties.portalURL + endpointPaths[key] + '?p_auth=' + properties.authToken;
}

Object.assign(properties, endpointPaths);