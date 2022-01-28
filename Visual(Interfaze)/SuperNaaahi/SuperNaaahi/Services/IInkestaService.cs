using SuperNaaahi.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace SuperNaaahi.Services
{
    /// <summary>
    /// InkestaServicen interfazea
    /// </summary>
    public interface IInkestaService
    {
       Task InkestaBete(Inkesta i);
       Task InkestaAldatu(Inkesta i);
       Task <Inkesta> KonprobatuKorreoa(string korreoa);

    }
}
