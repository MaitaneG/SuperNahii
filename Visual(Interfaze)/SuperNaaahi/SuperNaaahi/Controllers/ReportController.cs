using AspNetCore.Reporting;
using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.Mvc;
using SuperNaaahi.Services;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SuperNaaahi.Controllers
{
    public class ReportController : Controller
    {
        private readonly IWebHostEnvironment _webHostEnvironment;
        private readonly IPuntuazioaService _puntuazioaService;

        public ReportController(IWebHostEnvironment webHostEnvironment, IPuntuazioaService puntuazioaService)
        {
            _webHostEnvironment = webHostEnvironment;
            _puntuazioaService = puntuazioaService;
        }
        public async Task<IActionResult> Inprimatu()
        {
            Encoding.RegisterProvider(CodePagesEncodingProvider.Instance);

            string mimtype = "";
            int extension = 1;
            var path = $"{_webHostEnvironment.WebRootPath}\\Reports\\SuperNaaahiReport.rdlc";
            Dictionary<string, string> parameters = new Dictionary<string, string>();
           

            var hallOfFame = await _puntuazioaService.GetHallOfFame();
            var hallOfShame = await _puntuazioaService.GetHallOfShame();

            LocalReport localReport=new LocalReport(path);
            localReport.AddDataSource("DataSetHallOfFame", hallOfFame);
            localReport.AddDataSource("DataSetHallOfShame", hallOfShame);
            var result = localReport.Execute(RenderType.Pdf, extension, parameters, mimtype);
            return File(result.MainStream, "application/pdf");

        }
    }
}
