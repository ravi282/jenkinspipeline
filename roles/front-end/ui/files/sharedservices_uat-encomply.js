var sharedService = angular.module("SharedService", ['ngStorage', 'ngToast']);

sharedService.constant("context_path", "https://api-uat.taxilla.com/mapro");
sharedService.constant("search_context_path", "https://api-uat.taxilla.com/search");
sharedService.constant("resources_path", "https://api-uat.taxilla.com");

sharedService.constant("production_path", "https://uat.taxilla.com");
sharedService.constant("base_href", "");
sharedService.constant("platform_environment", "uat");

sharedService.constant("logoPath", "img/taxilla");

sharedService.config(['$sceDelegateProvider', 'context_path', function ($sceDelegateProvider, resources_path) {
    $sceDelegateProvider.resourceUrlWhitelist([
        'self',
        resources_path + "/**",
    ]);
}]);