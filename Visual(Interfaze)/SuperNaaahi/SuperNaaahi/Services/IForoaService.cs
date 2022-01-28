using SuperNaaahi.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace SuperNaaahi.Services
{
    /// <summary>
    /// ForoaServicen interfazeak
    /// </summary>
     public interface IForoaService
    {
        /// <summary>
        /// Foroa bete kudeatu
        /// </summary>
        /// <param name="f"></param>
        /// <returns></returns>
        Task Komentatu(Foroa f);
        /// <summary>
        /// Komentarioak kudeatu
        /// </summary>
        /// <returns>Komentarioen lista</returns>
        Task<IList<Foroa>> KomentarioakLortu();
    }
}
