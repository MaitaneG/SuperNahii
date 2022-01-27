using Microsoft.EntityFrameworkCore;
using SuperNaaahi.Data;
using SuperNaaahi.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace SuperNaaahi.Services
{
    public class InkestaService : IInkestaService
    {
        private readonly SuperNaaahiDbContext _superNaaahiDbContext;

        public InkestaService(SuperNaaahiDbContext superNaaahiDbContext)
        {
            _superNaaahiDbContext = superNaaahiDbContext;
        }

        public async Task InkestaBete(Inkesta i)
        {
            try
            {
         
                _superNaaahiDbContext.Inkesta.Add(i);
                _superNaaahiDbContext.SaveChanges();
            }
            catch(Exception ex)
            {
            }
        }
        public async Task<Inkesta> KonprobatuKorreoa(string korreoa)
        {
            var inkesta = await _superNaaahiDbContext.Inkesta.SingleOrDefaultAsync(i => i.Korreoa == korreoa);
            return inkesta;
            
        }
        public async Task InkestaAldatu(Inkesta inkesta)
        {
            var inkestaEginda = await _superNaaahiDbContext.Inkesta.SingleOrDefaultAsync(i => i.Korreoa == inkesta.Korreoa);
            inkestaEginda.Balorazioa = inkesta.Balorazioa;
            inkestaEginda.Hobetzeko = inkesta.Hobetzeko;
            inkestaEginda.Gomendatu = inkesta.Gomendatu;

            _superNaaahiDbContext.SaveChanges();
        }
    }
}
