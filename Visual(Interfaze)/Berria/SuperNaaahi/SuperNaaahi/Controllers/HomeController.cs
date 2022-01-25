﻿using Microsoft.AspNetCore.Authorization;
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
    /**
     * Home karpetan dauden bistak kontrolatzeko
     */
    public class HomeController : Controller
    {
        private readonly ILogger<HomeController> _logger;
        private readonly IInkestaService _inkestaService;
        private readonly IForoaService _foroaService;

        public HomeController(ILogger<HomeController> logger, IInkestaService inkestaService, IForoaService foroaService)
        {
            _logger = logger;
            _inkestaService = inkestaService;
            _foroaService = foroaService;
        }

        /**
         * Index bista (Pagina nagusia) bistaratzeko
         */
        public IActionResult Index()
        {
            return View();
        }

        /**
         * General bista (Puntuazio guztiak) bistaratzeko
         */
        public IActionResult General()
        {
            return View();
        }

        /**
         * HallOfFame bista (Puntuazio honenak) bistaratzeko
         */
        public IActionResult HallOfFame()
        {
            return View();
        }
     
        /**
         * HallOfShame bista (Puntuazio txarrenak) bistaratzeko
         */
        public IActionResult HallOfShame()
        {
            return View();
        }

        /**
         * Foroa bista bistaratzeko
         */
        [Authorize]
        public IActionResult Foroa()
        {
            return View();
        }
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

        /**
         * Inkesta bista bistaratzeko
         */
        [Authorize]
        public IActionResult Inkesta()
        {
            return View();
        }

        /**
         * Inkesta bat betetzen denean
         */
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

        /**
         * Privacy bista bistaratzeko
         */
        public IActionResult Privacy()
        {
            return View();
        }

        /**
         * Erroreak bistaratzeko
         */
        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }
    }
}
