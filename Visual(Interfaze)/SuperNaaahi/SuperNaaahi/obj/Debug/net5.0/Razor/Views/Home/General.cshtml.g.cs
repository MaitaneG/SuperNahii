#pragma checksum "C:\Users\gallastegui.maitane\Desktop\SuperNahii\Visual(Interfaze)\SuperNaaahi\SuperNaaahi\Views\Home\General.cshtml" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "fb7f7b60217028ed178ef94a54cd24e80ec1d671"
// <auto-generated/>
#pragma warning disable 1591
[assembly: global::Microsoft.AspNetCore.Razor.Hosting.RazorCompiledItemAttribute(typeof(AspNetCore.Views_Home_General), @"mvc.1.0.view", @"/Views/Home/General.cshtml")]
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
#line 1 "C:\Users\gallastegui.maitane\Desktop\SuperNahii\Visual(Interfaze)\SuperNaaahi\SuperNaaahi\Views\_ViewImports.cshtml"
using SuperNaaahi;

#line default
#line hidden
#nullable disable
#nullable restore
#line 2 "C:\Users\gallastegui.maitane\Desktop\SuperNahii\Visual(Interfaze)\SuperNaaahi\SuperNaaahi\Views\_ViewImports.cshtml"
using SuperNaaahi.Models;

#line default
#line hidden
#nullable disable
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"fb7f7b60217028ed178ef94a54cd24e80ec1d671", @"/Views/Home/General.cshtml")]
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"01601b6e0c93b761b22bb07274fb56ad3f53f02b", @"/Views/_ViewImports.cshtml")]
    public class Views_Home_General : global::Microsoft.AspNetCore.Mvc.Razor.RazorPage<IEnumerable<SuperNaaahi.Models.PuntuazioaModel>>
    {
        #pragma warning disable 1998
        public async override global::System.Threading.Tasks.Task ExecuteAsync()
        {
            WriteLiteral("\r\n");
            WriteLiteral("\r\n");
#nullable restore
#line 4 "C:\Users\gallastegui.maitane\Desktop\SuperNahii\Visual(Interfaze)\SuperNaaahi\SuperNaaahi\Views\Home\General.cshtml"
  
    ViewData["Title"] = "Ranking orokorra";

#line default
#line hidden
#nullable disable
            WriteLiteral("<h1>");
#nullable restore
#line 7 "C:\Users\gallastegui.maitane\Desktop\SuperNahii\Visual(Interfaze)\SuperNaaahi\SuperNaaahi\Views\Home\General.cshtml"
Write(ViewData["Title"]);

#line default
#line hidden
#nullable disable
            WriteLiteral("</h1>\r\n\r\n<br />\r\n\r\n");
#nullable restore
#line 11 "C:\Users\gallastegui.maitane\Desktop\SuperNahii\Visual(Interfaze)\SuperNaaahi\SuperNaaahi\Views\Home\General.cshtml"
Write(await Component.InvokeAsync("Puntuazioak"));

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n");
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
