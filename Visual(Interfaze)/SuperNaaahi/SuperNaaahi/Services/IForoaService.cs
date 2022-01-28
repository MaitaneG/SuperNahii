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
        Task Komentatu(Foroa f);
        Task<IList<Foroa>> KomentarioakLortu();
    }
}
