var sharedService = angular.module("SharedService", ['ngStorage', 'ngToast']);

sharedService.constant("context_path", "https://api.taxilla.com/mapro");
sharedService.constant("search_context_path", "https://api.taxilla.com/search");
sharedService.constant("resources_path", "https://api.taxilla.com");

/*
//This must be used for local(dev) environment deployed
*/
sharedService.constant("production_path", "https://easemygst.taxilla.com");
sharedService.constant("base_href", "");
sharedService.constant("platform_environment", "emgprod");


sharedService.constant("logoPath", "img/emg");

sharedService.config(['$sceDelegateProvider', 'context_path', function ($sceDelegateProvider, resources_path) {
$sceDelegateProvider.resourceUrlWhitelist([
'self',
resources_path + "/**",
]);
}]);
