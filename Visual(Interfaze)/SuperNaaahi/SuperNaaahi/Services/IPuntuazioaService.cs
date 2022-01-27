using SuperNaaahi.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace SuperNaaahi.Services
{
    public interface IPuntuazioaService
    {

        Task<List<PuntuazioaModel>> GetPuntuazioak();
        Task<List<PuntuazioaModel>> GetHallOfFame();
        Task<List<PuntuazioaModel>> GetHallOfShame();
    }
}
