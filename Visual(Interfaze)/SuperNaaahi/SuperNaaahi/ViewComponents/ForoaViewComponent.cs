using Microsoft.AspNetCore.Mvc;
using SuperNaaahi.Services;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace SuperNaaahi.ViewComponents
{
    /// <summary>
    /// Foroa view-rako konponenteen view-a kudeatzeko
    /// </summary>
    public class ForoaViewComponent:ViewComponent
    {
        private readonly IForoaService _foroaService;
        /// <summary>
        /// Foroa ViewConponent-earen konstruktorea
        /// </summary>
        /// <param name="foroaService"></param>
        public ForoaViewComponent(IForoaService foroaService)
        {
            _foroaService = foroaService;
        }
        /// <summary>
        /// Viee-ra bidaltzen dio komentarioen informazioa
        /// </summary>
        /// <returns> Komentarioaren lista itzuli</returns>
        public async Task<IViewComponentResult> InvokeAsync()
        {
            return View(await _foroaService.KomentarioakLortu());

        }
    }
}
