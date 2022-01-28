using Microsoft.AspNetCore.Mvc;
using SuperNaaahi.Services;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace SuperNaaahi.ViewComponents
{
    /// <summary>
    /// Putnuazio onenaren view-rako konponenteen view-a kudeatzeko 
    /// </summary>
    public class HallOfFameViewComponent: ViewComponent
    {
        private readonly IPuntuazioaService _puntuazioaService;
        /// <summary>
        /// Puntuazio onenaren ViewConponent-earen konstruktorea
        /// </summary>
        /// <param name="puntuazioaService"></param>
        public HallOfFameViewComponent(IPuntuazioaService puntuazioaService)
        {
            _puntuazioaService = puntuazioaService;
        }
        /// <summary>
        /// View-ra bidaltzen dio puntuazio onenen informazioa
        /// </summary>
        /// <returns></returns>
        public async Task<IViewComponentResult> InvokeAsync()
        {
            return View(await _puntuazioaService.GetHallOfFame());

        }
    }
}
