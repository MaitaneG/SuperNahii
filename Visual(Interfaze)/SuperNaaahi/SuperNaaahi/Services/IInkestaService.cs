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
        /// <summary>
        /// Inkesta bete kudeatu
        /// </summary>
        /// <param name="i"></param>
        /// <returns></returns>
       Task InkestaBete(Inkesta i);

        /// <summary>
        /// Inkesta aldatu kudeatu
        /// </summary>
        /// <param name="i"></param>
        /// <returns></returns>
       Task InkestaAldatu(Inkesta i);
        /// <summary>
        /// Inkesta betetzeko konprobatu emaila
        /// </summary>
        /// <param name="korreoa"></param>
        /// <returns>Email bereko inkesta</returns>
       Task <Inkesta> KonprobatuKorreoa(string korreoa);

    }
}
