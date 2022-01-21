using Microsoft.AspNetCore.Mvc;
using SuperNaaahi.Services;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace SuperNaaahi.ViewComponents
{
    public class PuntuazioakViewComponent: ViewComponent
    {
        private readonly IPuntuazioaService _puntuazioaService;

        public PuntuazioakViewComponent(IPuntuazioaService ardoaService)
        {
            _puntuazioaService = ardoaService;
        }
        public async Task<IViewComponentResult> InvokeAsync()
        {
            return View(await _puntuazioaService.GetPuntuazioak());

        }
    }
}
