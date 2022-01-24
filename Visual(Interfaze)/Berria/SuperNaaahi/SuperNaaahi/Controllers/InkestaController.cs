using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using SuperNaaahi.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace SuperNaaahi.Controllers
{
    public class InkestaController : Controller
    {
        // GET: InkestaController
        public ActionResult Index()
        {
            return View();
        }

        // GET: InkestaController/Details/5
        public ActionResult Details(int id)
        {
            return View();
        }

        // GET: InkestaController/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: InkestaController/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create(Inkesta inkesta)
        {
            try
            {
                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }

        // GET: InkestaController/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: InkestaController/Edit/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit(int id, IFormCollection collection)
        {
            try
            {
                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }

        // GET: InkestaController/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: InkestaController/Delete/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Delete(int id, IFormCollection collection)
        {
            try
            {
                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }
    }
}
