using Microsoft.AspNetCore.Mvc;
using SuperNaaahi.Services;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace SuperNaaahi.ViewComponents
{
    /// <summary>
    /// Puntuazio guztien  view-rako konponenteen viw-a
    /// </summary>
    public class PuntuazioakViewComponent: ViewComponent
    {
        private readonly IPuntuazioaService _puntuazioaService;

        /// <summary>
        /// Puntuazio guzien ViewComponent-earen konstruktorea
        /// </summary>
        /// <param name="puntuazioaService"></param>
        public PuntuazioakViewComponent(IPuntuazioaService puntuazioaService)
        {
            _puntuazioaService = puntuazioaService;
        }
        /// <summary>
        /// View-ra bidaltzen dio puntuazio guztien informazioa
        /// </summary>
        /// <returns>Puntuazio guztiak itzuli </returns>
        public async Task<IViewComponentResult> InvokeAsync()
        {
            return View(await _puntuazioaService.GetPuntuazioak());

        }
    
    }
}
