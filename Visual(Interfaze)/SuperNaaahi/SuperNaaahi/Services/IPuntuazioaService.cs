using SuperNaaahi.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace SuperNaaahi.Services
{
    /// <summary>
    /// PuntuazioService interfazea
    /// </summary>
    public interface IPuntuazioaService
    {
   
        /// <summary>
        /// Puntuazio guztiak kudeatu
        /// </summary>
        /// <returns> Puntuazio guztien lista</returns>
        Task<List<PuntuazioaModel>> GetPuntuazioak();

        /// <summary>
        /// Puntuazio onenak kudeatu
        /// </summary>
        /// <returns>Puntuazio onenen lista </returns>
        Task<List<PuntuazioaModel>> GetHallOfFame();
        /// <summary>
        /// Puntuazio txarrenak kudeatu
        /// </summary>
        /// <returns>Puntuazio txarrenen lista </returns>
        Task<List<PuntuazioaModel>> GetHallOfShame();
   
        /// <summary>
        /// Rest-apitik partaide guztien kopurua kudeatu
        /// </summary>
        /// <returns>Partaide kopurua</returns>
        Task<int> GetPartidaKopurua();
   


    }
}
