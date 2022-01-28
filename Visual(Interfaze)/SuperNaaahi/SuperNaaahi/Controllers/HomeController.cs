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
    ///<sumary>
    /// Home karpetan dauden bistak kontrolatzeko
    /// </sumary>
    public class HomeController : Controller
    {
        private readonly ILogger<HomeController> _logger;
        private readonly IInkestaService _inkestaService;
        private readonly IForoaService _foroaService;
        private readonly IPuntuazioaService _puntuazioaService;

        /// <summary>
        /// HomeControllerraren konstruktorea
        /// </summary>
        /// <param name="logger"></param>
        /// <param name="inkestaService"></param>
        /// <param name="foroaService"></param>
        /// <param name="puntuazioaService"></param>
        public HomeController(ILogger<HomeController> logger, IInkestaService inkestaService, IForoaService foroaService, IPuntuazioaService puntuazioaService)
        {
            _logger = logger;
            _inkestaService = inkestaService;
            _foroaService = foroaService;
            _puntuazioaService = puntuazioaService;

        }

        /// <summary>
        /// Index bista (Pagina nagusia) bistaratzeko
        /// </summary>
        /// <returns> Index View-a itzuli</returns>

        public IActionResult Index()
        {
            return View();
        }

        /// <summary>
        /// General bista (Puntuazio guztiak) bistaratzeko
        /// </summary>
        /// <returns>General View-a (Ranking orokorra) itzuli </returns>
        public IActionResult General()
        {
            return View();
        }
        /// <summary>
        /// Select-ean aukeratzen duzun puntuazio kantitatea bistaratzeko
        /// </summary>
        /// <param name="puntua"></param>
        /// <returns>View-a</returns>
        public IActionResult AukeratuPuntuazioa(string puntua)
        {
            if (puntua.Equals("5"))
            {
                _puntuazioaService.GetBostPuntuazio();
            }
            else if (puntua.Equals("10"))
            {
                _puntuazioaService.GetHamarPuntuazio();

            }
            else if (puntua.Equals("15"))
            {
                _puntuazioaService.GetHamabostPuntuazio();
            }else if (puntua.Equals("Guztiak"))
            {
                _puntuazioaService.GetPuntuazioak();
            }
            return View();
        }

        /// <summary>
        /// HallOfFame bista (Puntuazio onenak) bistaratzeko
        /// </summary>
        /// <returns>Puntuazio onenaren View-a itzuli </returns>
        public IActionResult HallOfFame()
        {
            return View();
        }


        /// <summary>
        /// HallOfShame bista (Puntuazio txarrenak) bistaratzeko
        /// </summary>
        /// <returns>Puntuazio txarrenan View-a itzuli</returns>
        public IActionResult HallOfShame()
        {
            return View();
        }

        /// <summary>
        /// Foroa bista bistaratzeko
        /// Authorize: Foroa egiteko logeatuta egon behar duzu
        /// </summary>
        /// <returns>Foroaren View-a itzuli</returns>
        [Authorize]
        public IActionResult Foroa()
        {
            return View();
        }
        /// <summary>
        /// Foroa egin
        /// </summary>
        /// <param name="Foroa"></param>
        /// <returns>View-a itzuli</returns>
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Foroa(Foroa Foroa)
        {
            try
            {
                Foroa.Data = DateTime.Now;
                _foroaService.Komentatu(Foroa);
                return View();
            }
            catch
            {
                ViewBag.Alert = "Erabiltzaile honek inkesta beteta dauka";
                return View();
            }
        }

        /// <summary>
        /// Email bereko inkesta bistaratu inkesta orrian
        /// Authorize: Inkesta egiteko logeatuta egon behar duzu
        /// </summary>
        /// <returns>Inkestaren informazioa beteta badago</returns>
        [Authorize]
        public async Task<IActionResult> Inkesta()
        {
            Inkesta inkesta = await _inkestaService.KonprobatuKorreoa(HttpContext.User.Identity.Name);
            return View(inkesta);
        }

        /// <summary>
        /// Inkesta bete, iadanik inkesta beteta badago aukera daukazu aldaketak egiteko
        /// </summary>
        /// <param name="inkesta"></param>
        /// <returns>Inkesta egin eta Index View-a itzuli</returns>
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult>Inkesta(Inkesta inkesta)
        {
            if (ModelState.IsValid)
            {
                if((await _inkestaService.KonprobatuKorreoa(inkesta.Korreoa) != null))
                {
                    await _inkestaService.InkestaAldatu(inkesta);
                }
                else
                {
                    await _inkestaService.InkestaBete(inkesta);
                }
            }
            return RedirectToAction(nameof(Index));
        }

        /// <summary>
        ///  Privacy bista bistaratzeko
        /// </summary>
        /// <returns>Privacy View-a itzuli</returns>
        public IActionResult Privacy()
        {
            return View();
        }

        /// <summary>
        /// Erroreak bistaratu
        /// </summary>
        /// <returns>Errorea View-a</returns>
        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }
    }
}
