using Microsoft.AspNetCore.Mvc;
using SuperNaaahi.Services;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace SuperNaaahi.ViewComponents
{
    /// <summary>
    /// Puntuazio txarrenaren view-rako konponenteen viw-a
    /// </summary>
    public class HallOfShameViewComponent:ViewComponent
    {
        private readonly IPuntuazioaService _puntuazioaService;
        /// <summary>
        /// Puntuazio txarrenaren ViewComponet-aren Konstruktorea
        /// </summary>
        /// <param name="puntuazioaService"></param>
        public HallOfShameViewComponent(IPuntuazioaService puntuazioaService)
        {
            _puntuazioaService = puntuazioaService;
        }
        /// <summary>
        ///  View-ra bidaltzen dio puntuazio txarrenen informazioa
        /// </summary>
        /// <returns>Puntuazio txarrenak itzuli</returns>
        public async Task<IViewComponentResult> InvokeAsync()
        {
            return View(await _puntuazioaService.GetHallOfShame());

        }
    }
}
