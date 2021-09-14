var sharedService = angular.module("SharedService", ['ngStorage', 'ngToast']);

sharedService.constant("context_path", "http://kpmg-uat-lb-225724823.ap-south-1.elb.amazonaws.com/mapro");
sharedService.constant("search_context_path", "http://kpmg-uat-lb-225724823.ap-south-1.elb.amazonaws.com/search");
sharedService.constant("resources_path", "http://kpmg-uat-lb-225724823.ap-south-1.elb.amazonaws.com");

/*
//This must be used for local(dev) environment deployed
*/
sharedService.constant("production_path", "http://kpmg-uat-lb-225724823.ap-south-1.elb.amazonaws.com");
sharedService.constant("base_href", "");
sharedService.constant("platform_environment", "kpmguat");

sharedService.constant("logoPath", "img/kpmg");

sharedService.config(['$sceDelegateProvider', 'context_path', function ($sceDelegateProvider, resources_path) {
    $sceDelegateProvider.resourceUrlWhitelist([
        'self',
        resources_path + "/**",
    ]);
}]);