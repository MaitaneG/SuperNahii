#pragma checksum "C:\Users\arambarri.oihana\Desktop\SuperNahii\Visual(Interfaze)\SuperNaaahi\SuperNaaahi\Views\Shared\Components\Puntuazioak\Default.cshtml" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "6dbabf41392b929606c38542b0a0886a9fd12c4c"
// <auto-generated/>
#pragma warning disable 1591
[assembly: global::Microsoft.AspNetCore.Razor.Hosting.RazorCompiledItemAttribute(typeof(AspNetCore.Views_Shared_Components_Puntuazioak_Default), @"mvc.1.0.view", @"/Views/Shared/Components/Puntuazioak/Default.cshtml")]
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
#line 1 "C:\Users\arambarri.oihana\Desktop\SuperNahii\Visual(Interfaze)\SuperNaaahi\SuperNaaahi\Views\_ViewImports.cshtml"
using SuperNaaahi;

#line default
#line hidden
#nullable disable
#nullable restore
#line 2 "C:\Users\arambarri.oihana\Desktop\SuperNahii\Visual(Interfaze)\SuperNaaahi\SuperNaaahi\Views\_ViewImports.cshtml"
using SuperNaaahi.Models;

#line default
#line hidden
#nullable disable
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"6dbabf41392b929606c38542b0a0886a9fd12c4c", @"/Views/Shared/Components/Puntuazioak/Default.cshtml")]
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"01601b6e0c93b761b22bb07274fb56ad3f53f02b", @"/Views/_ViewImports.cshtml")]
    public class Views_Shared_Components_Puntuazioak_Default : global::Microsoft.AspNetCore.Mvc.Razor.RazorPage<IEnumerable<SuperNaaahi.Models.PuntuazioaModel>>
    {
        #pragma warning disable 1998
        public async override global::System.Threading.Tasks.Task ExecuteAsync()
        {
            WriteLiteral("\r\n<table class=\"table table-striped\" id=\"tabla\">\r\n    <thead>\r\n        <tr>\r\n            <th>Langilea</th>\r\n            <th>Puntuazioa</th>\r\n            <th>Data</th>\r\n        </tr>\r\n    </thead>\r\n    <tbody>\r\n\r\n");
#nullable restore
#line 15 "C:\Users\arambarri.oihana\Desktop\SuperNahii\Visual(Interfaze)\SuperNaaahi\SuperNaaahi\Views\Shared\Components\Puntuazioak\Default.cshtml"
         foreach (var item in Model)
                {

#line default
#line hidden
#nullable disable
            WriteLiteral("        <tr");
            BeginWriteAttribute("id", " id=\"", 347, "\"", 364, 2);
            WriteAttributeValue("", 352, "row-", 352, 4, true);
#nullable restore
#line 17 "C:\Users\arambarri.oihana\Desktop\SuperNahii\Visual(Interfaze)\SuperNaaahi\SuperNaaahi\Views\Shared\Components\Puntuazioak\Default.cshtml"
WriteAttributeValue("", 356, item.Id, 356, 8, false);

#line default
#line hidden
#nullable disable
            EndWriteAttribute();
            WriteLiteral(">\r\n            <th>");
#nullable restore
#line 18 "C:\Users\arambarri.oihana\Desktop\SuperNahii\Visual(Interfaze)\SuperNaaahi\SuperNaaahi\Views\Shared\Components\Puntuazioak\Default.cshtml"
           Write(Html.DisplayFor(modelItem => item.Jokalari));

#line default
#line hidden
#nullable disable
            WriteLiteral("</th>\r\n            <th>");
#nullable restore
#line 19 "C:\Users\arambarri.oihana\Desktop\SuperNahii\Visual(Interfaze)\SuperNaaahi\SuperNaaahi\Views\Shared\Components\Puntuazioak\Default.cshtml"
           Write(Html.DisplayFor(modelItem => item.Puntuazioa));

#line default
#line hidden
#nullable disable
            WriteLiteral("</th>\r\n            <th>");
#nullable restore
#line 20 "C:\Users\arambarri.oihana\Desktop\SuperNahii\Visual(Interfaze)\SuperNaaahi\SuperNaaahi\Views\Shared\Components\Puntuazioak\Default.cshtml"
           Write(Html.DisplayFor(modelItem => item.Data));

#line default
#line hidden
#nullable disable
            WriteLiteral("</th>\r\n        </tr>\r\n");
#nullable restore
#line 22 "C:\Users\arambarri.oihana\Desktop\SuperNahii\Visual(Interfaze)\SuperNaaahi\SuperNaaahi\Views\Shared\Components\Puntuazioak\Default.cshtml"
                }

#line default
#line hidden
#nullable disable
            WriteLiteral("    </tbody>\r\n</table>\r\n\r\n");
        }
        #pragma warning restore 1998
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.ViewFeatures.IModelExpressionProvider ModelExpressionProvider { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.IUrlHelper Url { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.IViewComponentHelper Component { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.Rendering.IJsonHelper Json { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.Rendering.IHtmlHelper<IEnumerable<SuperNaaahi.Models.PuntuazioaModel>> Html { get; private set; }
    }
}
#pragma warning restore 1591
