using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;
using SuperNaaahi.Models;
using SuperNaaahi.Services;
using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Threading.Tasks;

namespace SuperNaaahi.Controllers
{
    public class HomeController : Controller
    {
        private readonly ILogger<HomeController> _logger;
        private readonly IInkestaService _inkestaService;

        public HomeController(ILogger<HomeController> logger, IInkestaService inkestaService)
        {
            _logger = logger;
            _inkestaService = inkestaService;
        }

        public IActionResult Index()
        {
            return View();
        }

        public IActionResult General()
        {
            return View();
        }
        public IActionResult HallOfFame()
        {
            return View();
        }
     
        public IActionResult HallOfShame()
        {
            return View();
        }

        public IActionResult Foroa()
        {
            return View();
        }

        public IActionResult Inkesta()
        {
            return View();
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Inkesta(Inkesta inkesta)
        {
            try
            {
                _inkestaService.InkestaBete(inkesta);

                return RedirectToAction(nameof(Index));
            }
            catch
            {
                ViewBag.Alert = "Erabiltzaile honek inkesta beteta dauka";
                return View();
            }
        }

        public IActionResult Privacy()
        {
            return View();
        }

        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }
    }
}
