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
    /// <summary>
    /// Reportea egiteko kontrolerra
    /// </summary>
    public class ReportController : Controller
    {
        private readonly IWebHostEnvironment _webHostEnvironment;
        private readonly IPuntuazioaService _puntuazioaService;

        /// <summary>
        /// ReportControlerraren konstruktorea
        /// </summary>
        /// <param name="webHostEnvironment"></param>
        /// <param name="puntuazioaService"></param>
        public ReportController(IWebHostEnvironment webHostEnvironment, IPuntuazioaService puntuazioaService)
        {
            _webHostEnvironment = webHostEnvironment;
            _puntuazioaService = puntuazioaService;
        }

        /// <summary>
        /// Informea inprimtatu
        /// </summary>
        /// <returns>informea pdf</returns>
        public async Task<IActionResult> InprimatuHallOf()
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
        public async Task<IActionResult> InprimatuRankingOrokorra()
        {
            Encoding.RegisterProvider(CodePagesEncodingProvider.Instance);

            string mimtype = "";
            int extension = 1;
            var path = $"{_webHostEnvironment.WebRootPath}\\Reports\\SuperNaaahiRankingOrokorReport.rdlc";
            Dictionary<string, string> parameters = new Dictionary<string, string>();
           


            var rankingOrokor = await _puntuazioaService.GetPuntuazioak();

            var kopurua = await _puntuazioaService.GetPartidaKopurua();
            parameters.Add("partidaKopurua", kopurua.ToString());

            LocalReport localReport = new LocalReport(path);
            
            localReport.AddDataSource("DataSetRanking", rankingOrokor);
            var result = localReport.Execute(RenderType.Pdf, extension, parameters, mimtype);
            return File(result.MainStream, "application/pdf");

        }

    }
}
