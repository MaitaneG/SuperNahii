#pragma checksum "C:\Users\arambarri.oihana\Desktop\SuperNahii\Visual(Interfaze)\Berria\SuperNaaahi\SuperNaaahi\Views\Shared\Components\Foroa\Default.cshtml" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "69cf99d892685b9570e831619f2b3a1c8b2ad920"
// <auto-generated/>
#pragma warning disable 1591
[assembly: global::Microsoft.AspNetCore.Razor.Hosting.RazorCompiledItemAttribute(typeof(AspNetCore.Views_Shared_Components_Foroa_Default), @"mvc.1.0.view", @"/Views/Shared/Components/Foroa/Default.cshtml")]
namespace AspNetCore
{
    #line hidden
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Threading.Tasks;
    using Microsoft.AspNetCore.Mvc;
    using Microsoft.AspNetCore.Mvc.Rendering;
    using Microsoft.AspNetCore.Mvc.ViewFeatures;
#nullable restore
#line 1 "C:\Users\arambarri.oihana\Desktop\SuperNahii\Visual(Interfaze)\Berria\SuperNaaahi\SuperNaaahi\Views\_ViewImports.cshtml"
using SuperNaaahi;

#line default
#line hidden
#nullable disable
#nullable restore
#line 2 "C:\Users\arambarri.oihana\Desktop\SuperNahii\Visual(Interfaze)\Berria\SuperNaaahi\SuperNaaahi\Views\_ViewImports.cshtml"
using SuperNaaahi.Models;

#line default
#line hidden
#nullable disable
#nullable restore
#line 1 "C:\Users\arambarri.oihana\Desktop\SuperNahii\Visual(Interfaze)\Berria\SuperNaaahi\SuperNaaahi\Views\Shared\Components\Foroa\Default.cshtml"
using Microsoft.AspNetCore.Identity;

#line default
#line hidden
#nullable disable
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"69cf99d892685b9570e831619f2b3a1c8b2ad920", @"/Views/Shared/Components/Foroa/Default.cshtml")]
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"01601b6e0c93b761b22bb07274fb56ad3f53f02b", @"/Views/_ViewImports.cshtml")]
    public class Views_Shared_Components_Foroa_Default : global::Microsoft.AspNetCore.Mvc.Razor.RazorPage<IEnumerable<SuperNaaahi.Models.Foroa>>
    {
        #pragma warning disable 1998
        public async override global::System.Threading.Tasks.Task ExecuteAsync()
        {
            WriteLiteral("\r\n");
#nullable restore
#line 8 "C:\Users\arambarri.oihana\Desktop\SuperNahii\Visual(Interfaze)\Berria\SuperNaaahi\SuperNaaahi\Views\Shared\Components\Foroa\Default.cshtml"
 foreach (var item in Model)
{
  

#line default
#line hidden
#nullable disable
            WriteLiteral("    <div class=\"kontainer darker\">\r\n        <img src=\"/images/user.png\" alt=\"Avatar\" class=\"right\">\r\n\r\n        <p><b>");
#nullable restore
#line 14 "C:\Users\arambarri.oihana\Desktop\SuperNahii\Visual(Interfaze)\Berria\SuperNaaahi\SuperNaaahi\Views\Shared\Components\Foroa\Default.cshtml"
         Write(item.Korreoa);

#line default
#line hidden
#nullable disable
            WriteLiteral(":</b> ");
#nullable restore
#line 14 "C:\Users\arambarri.oihana\Desktop\SuperNahii\Visual(Interfaze)\Berria\SuperNaaahi\SuperNaaahi\Views\Shared\Components\Foroa\Default.cshtml"
                            Write(item.Komentarioa);

#line default
#line hidden
#nullable disable
            WriteLiteral("</p>\r\n        <span class=\"time-right\">");
#nullable restore
#line 15 "C:\Users\arambarri.oihana\Desktop\SuperNahii\Visual(Interfaze)\Berria\SuperNaaahi\SuperNaaahi\Views\Shared\Components\Foroa\Default.cshtml"
                            Write(item.Data);

#line default
#line hidden
#nullable disable
            WriteLiteral("</span>\r\n    </div>\r\n");
#nullable restore
#line 17 "C:\Users\arambarri.oihana\Desktop\SuperNahii\Visual(Interfaze)\Berria\SuperNaaahi\SuperNaaahi\Views\Shared\Components\Foroa\Default.cshtml"
 
    



}

#line default
#line hidden
#nullable disable
        }
        #pragma warning restore 1998
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public UserManager<IdentityUser> UserManager { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public SignInManager<IdentityUser> SignInManager { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.ViewFeatures.IModelExpressionProvider ModelExpressionProvider { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.IUrlHelper Url { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.IViewComponentHelper Component { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.Rendering.IJsonHelper Json { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.Rendering.IHtmlHelper<IEnumerable<SuperNaaahi.Models.Foroa>> Html { get; private set; }
    }
}
#pragma warning restore 1591
