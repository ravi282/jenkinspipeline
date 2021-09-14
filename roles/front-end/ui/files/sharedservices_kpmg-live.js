var sharedService = angular.module("SharedService", ['ngStorage', 'ngToast']);

sharedService.constant("context_path", "https://stage-gstpilot.in.kpmg.com/mapro");
sharedService.constant("search_context_path", "https://stage-gstpilot.in.kpmg.com/search");
sharedService.constant("resources_path", "https://stage-gstpilot.in.kpmg.com");


sharedService.constant("production_path", "https://stage-gstpilot.in.kpmg.com");
sharedService.constant("base_href", "");
sharedService.constant("platform_environment", "kpmgprod");

sharedService.constant("logoPath", "img/kpmg");

sharedService.config(['$sceDelegateProvider', 'context_path', function ($sceDelegateProvider, resources_path) {
    $sceDelegateProvider.resourceUrlWhitelist([
        'self',
        resources_path + "/**",
    ]);
}]);