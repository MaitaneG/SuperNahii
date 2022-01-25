using Microsoft.AspNetCore.Mvc;
using SuperNaaahi.Services;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace SuperNaaahi.ViewComponents
{
    public class ForoaViewComponent:ViewComponent
    {
        private readonly IForoaService _foroaService;
        public ForoaViewComponent(IForoaService foroaService)
        {
            _foroaService = foroaService;
        }
        public async Task<IViewComponentResult> InvokeAsync()
        {
            return View(await _foroaService.KomentarioakLortu());

        }
    }
}
